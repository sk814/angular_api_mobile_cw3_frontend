# Generated by Django 3.1.3 on 2020-11-25 19:45

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('virusTestingApp', '0004_registereduser_font_size'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='registereduser',
            name='font_size',
        ),
    ]
