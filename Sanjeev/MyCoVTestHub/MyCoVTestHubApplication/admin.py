from django.contrib import admin
from .models import VirusTesting, Place, GivenTTN
from django_admin_listfilter_dropdown.filters import DropdownFilter
from rangefilter.filter import DateTimeRangeFilter
from leaflet.admin import LeafletGeoAdmin

class VirusTestingAdmin(admin.ModelAdmin):
    readonly_fields = ('created',)
    list_display = ('ttn', 'fullname', 'email','age',  'address', 'postcode', 'result','gender','created','comment')
    list_filter = (('age',DropdownFilter),('postcode',DropdownFilter),('result',DropdownFilter),('created',DateTimeRangeFilter), )
    ordering = ('created','age','result','postcode')
    search_fields = ('postcode','ttn','created', 'fullname', 'email','age', 'gender', 'address', 'postcode', 'result','comment',)
    date_hierarchy = 'created'
    # fields = (('ttn', 'fullname'), 'email','age', 'gender', 'address', 'postcode', 'result', 'comment','created')

    fieldsets = (
        (None, {
            'fields': (('ttn', 'fullname'), ('email','age'), ('gender','result'), ('address', 'postcode'),  'comment'),
        }),
        ('Created Date (NON-Editable)',
         {
           'fields':('created',),
             'description': 'Date and Time of information created',
             'classes':('collapse',),
         }),
    )

class GivenTTNAdmin(admin.ModelAdmin):
    list_display = ('givenTTN',)

admin.site.register(GivenTTN, GivenTTNAdmin)
admin.site.register(VirusTesting,VirusTestingAdmin)
admin.site.register(Place, LeafletGeoAdmin)

