from django.db import models

# Create your models here.
class RegisteredUser(models.Model):
    name = models.CharField(max_length=60)
    email = models.CharField(max_length=60,unique=True,)
    age = models.CharField(max_length=60)
    gender = models.CharField(max_length=60)
    address = models.CharField(max_length=60)
    postcode = models.CharField(max_length=60)
    ttn = models.CharField(max_length=60,unique=True,)
    testResult = models.CharField(max_length=60)
    # font_size=models.IntegerField()

    def __str__(self):
        return self.name