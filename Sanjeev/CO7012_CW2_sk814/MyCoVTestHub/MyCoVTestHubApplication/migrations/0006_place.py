# Generated by Django 3.1.3 on 2020-11-22 17:52

from django.db import migrations, models
import djgeojson.fields


class Migration(migrations.Migration):

    dependencies = [
        ('MyCoVTestHubApplication', '0005_auto_20201121_1730'),
    ]

    operations = [
        migrations.CreateModel(
            name='Place',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=200)),
                ('location', djgeojson.fields.PointField()),
            ],
        ),
    ]
