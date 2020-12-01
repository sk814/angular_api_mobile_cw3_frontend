from django import forms
from .models  import RegisteredUser
class TestForm(forms.ModelForm):
    class Meta:
        model=RegisteredUser
        fields= ['name','email','age','gender','address','postcode','ttn','testResult']