from django.shortcuts import render
from mycovtesthubapp.forms import FormClass
from .forms import FormClass
from .models import Testform
from django.views.generic import CreateView

# Create your views here.
from django.http import HttpResponse


def index(CreateView):
    model=Testform
    form_class= FormClass
    template_name="frontpage.html"
    defaultform=FormClass(CreateView.POST or None)
    # fields="__all__"
    # return HttpResponse("Hello IT IS WORKING.")
    if defaultform.is_valid():

        vaildTTN=['MM2874Z6','FEQQ6UUG','34GC829B','CB8FBCCM','8RL4ENTK','57UBS5J6','4F7YKH9G','R9KZ2NXL','YBQUVXHL','CCZTQ8KW']

        ttnbyuser=defaultform.cleaned_data['ttncode']
        if ttnbyuser in vaildTTN:
            defaultform.save()
            return render(CreateView, 'frontpage.html', {'form': defaultform})
        else:
            return render(CreateView, 'frontpage.html', {'form': defaultform, 'fieldsError': 'Entered TTN is not valid.'})

    return render(CreateView,'frontpage.html',{'form':defaultform})
