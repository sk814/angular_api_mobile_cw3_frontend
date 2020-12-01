from django.contrib import admin
from .models import Testform

admin.site.index_title="Admin-Dashboard"
admin.site.site_header="Admin-Dashboard"

class AdminPage(admin.ModelAdmin):
    list_display = ('ttncode', 'testResult', 'fullname', 'emailid', 'address', 'postcode', 'gender', 'age')
    # list_filter = ('testResult',('postcode','age'))
    list_filter = ('testResult','postcode','age')

admin.site.register(Testform,AdminPage)