from django.shortcuts import render, redirect

from virusTestingApp.forms import TestForm

valid=False
def testReport(request):
    form=TestForm(request.POST or None)

    ttnList=[]

    if form.is_valid():

        ttnEntered=form.cleaned_data['ttn']

        # # Reading the file TTN.txt file to check
        allTTN = open("availableTTN.txt", "r")
        # Check for valid TTN
        for aTTN in allTTN:
            ttnList.append(aTTN.strip())
            print(ttnList)
        # # ttnList = map(lambda s: s.strip(), ttnList)\

        if ttnEntered in ttnList:
            form.save()
            return redirect("testReport")
        else:
            return render(request, 'virusTestingApp/testing-form.html', {'form': form, 'error': 'Invalid TTN!'})

    return render(request,'virusTestingApp/testing-form.html',{'form':form})
