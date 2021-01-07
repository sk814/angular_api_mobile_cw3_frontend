from django.db import models
from djgeojson.fields import PointField


class VirusTesting(models.Model):
    created = models.DateTimeField(auto_now_add=True)
    ttn = models.CharField(max_length=100, null=False,unique=True, error_messages={'unique':"This TTN has already been used."})
    fullname = models.CharField(max_length=100,null=False)
    email = models.CharField(max_length=100,null=False,unique=True,error_messages={'unique':"This EMAIL has already been used."})
    age = models.IntegerField(default=1, null=False)
    gender = models.CharField(max_length=100, null=False)
    address = models.CharField(max_length=100, null=False)
    postcode = models.CharField(max_length=100, null=False)
    result = models.CharField(max_length=100, null=False)
    comment = models.TextField(blank=True)

    def __str__(self):
        return self.ttn

class Place(models.Model):

    name=models.CharField(max_length=200)
    location=PointField()

    def __str__(self):
        return self.name

class GivenTTN(models.Model):
    givenTTN=models.CharField(max_length=15, null=True,)
    def __str__(self):
        return self.givenTTN