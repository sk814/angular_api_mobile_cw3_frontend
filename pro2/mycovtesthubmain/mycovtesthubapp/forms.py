from django import forms
from .models  import Testform

class FormClass(forms.ModelForm):


    class Meta:
        model=Testform
        genderCHOICES = ('Male','Female','Other')
        resultCHOICES = ('Posotove','Negative','Unknown')
        fields= ('ttncode','testResult','fullname','emailid','address','postcode','gender','age')

        widgets={
            'ttncode': forms.TextInput(attrs={'class':'form-control','placeholder':'Unique and Valid'}),
            'testResult': forms.TextInput(attrs={'class': 'form-control'},),
            # 'testResult': forms.ChoiceField(choices=resultCHOICES),
            'fullname': forms.TextInput(attrs={'class': 'form-control'}),
            'emailid': forms.TextInput(attrs={'class':'form-control','placeholder':'Unique'}),
            'address': forms.TextInput(attrs={'class': 'form-control'}),
            'postcode': forms.TextInput(attrs={'class': 'form-control'}),
            'gender': forms.TextInput(attrs={'class': 'form-control'},),
            # 'gender': forms.TypedChoiceField(choices= genderCHOICES,),
            'age': forms.NumberInput(attrs={'class': 'form-control'}),
        }