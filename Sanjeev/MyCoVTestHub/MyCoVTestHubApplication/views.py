from django.contrib import messages
from django.core.exceptions import ValidationError
from django.http import HttpResponseRedirect
from django.shortcuts import render
from django.http import HttpResponse
from .forms import VirusTestingForm
from .models import VirusTesting
from .models import GivenTTN


def home(request):
    if request.method == 'GET':
        return render(request, 'homepage.html', {'form': VirusTestingForm()})
    else:
        try:
            form = VirusTestingForm(request.POST)
            user = form.save(commit=False)
            # 'ttn', 'fullname', 'email', 'age', 'gender', 'address', 'postcode', 'result', 'comment'
            user.ttn = request.POST['ttn']
            user.fullname = request.POST['fullname']
            user.email = request.POST['email']
            user.age = request.POST['age']
            user.gender = request.POST['gender']
            user.address = request.POST['address']
            user.postcode = request.POST['postcode']
            user.result = request.POST['result']
            user.comment = request.POST['comment']
            # user.email.get_or_create(request.POST['email'])
            if form.is_valid():
                user.save()
            return HttpResponse('<h1 style="color:blue;">Thanks! {0}, Data Received. </h1>'.format(user.fullname))
        except ValueError as error:
            # print("ERROR! : ",error)
            # print(ValueError.)
            # print(ValueError.__cause__)
            return HttpResponse('<h2 style="color:red;">Error! <b>{}</b> TTN or Email already used. please use different TTA/Email by reloading the page</h2>'.format(error))

            # return render(request, 'homepage.html',
            #               {'form': VirusTestingForm(), 'error': 'Bad data passed in. Try again.'})
        except ValidationError:
            print("ERROR!")
            return render(request, 'homepage.html',
                          {'form': VirusTestingForm(), 'error': 'Bad data passed in. Try again.'})
        except Exception as e:
            print("ERROR!3:", e)
            return render(request, 'homepage.html',
                          {'form': VirusTestingForm(), 'error': 'Bad data passed in. Try again.'})

def checkTTN(request):
    if request.method == 'GET':
        ttnForm= request.GET["ttn"]
        check=VirusTesting.objects.filter(ttn=ttnForm)
        checkValid=GivenTTN.objects.filter(givenTTN=ttnForm)
        if len(checkValid)==0:
            return  HttpResponse('NotValid')
        elif len(check)==1:
            return HttpResponse('Exists')
        else:
            return HttpResponse('Not Exists')

def checkEmail(request):
    if request.method == 'GET':
        emailDB= request.GET["email"]
        check2=VirusTesting.objects.filter(email=emailDB)
        if len(check2)==1:
            return HttpResponse('Exists')
        else:
            return HttpResponse('Not Exists')

def handler404(request):
    return render(request, '404.html', status=404)
def handler500(request):
    return render(request, '500.html', status=500)