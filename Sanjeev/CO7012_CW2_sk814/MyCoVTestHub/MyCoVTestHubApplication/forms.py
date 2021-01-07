from django.forms import ModelForm
from .models import VirusTesting

class VirusTestingForm(ModelForm):
    class Meta:
        model = VirusTesting
        fields = ['ttn', 'fullname', 'email','age', 'gender', 'address', 'postcode', 'result', 'comment']
