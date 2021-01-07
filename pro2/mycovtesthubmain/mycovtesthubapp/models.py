from django.db import models

# Create your models here.
from django.db import models

# Create your models here.
class Testform(models.Model):
    ttncode = models.CharField(max_length=20, unique=True)
    testResult = models.CharField(max_length=20)
    fullname = models.CharField(max_length=30)
    emailid = models.CharField(max_length=30,unique=True)
    address = models.CharField(max_length=50)
    postcode = models.CharField(max_length=50)
    gender = models.CharField(max_length=20)
    age = models.CharField(max_length=10)
