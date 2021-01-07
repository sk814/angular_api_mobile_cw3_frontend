from django.contrib import admin
from .models import RegisteredUser
# Register your models here.
admin.site.site_header="Cov Testing Dashboard"
admin.site.site_title="Dashboard"
admin.site.index_title="Dashboard for Cov test report Shangri-la"


class Dashboard(admin.ModelAdmin):
    list_display = ('name','email','age','gender','address','postcode','ttn','testResult')
    # change_list_template = "sdsd"
    list_filter = ('testResult','age','postcode',)
    # change_list_template = 'virusTestingApp/registeredUsers.html'

    # //http://127.0.0.1:8000/dashboard/virusTestingApp/registereduser/

admin.site.register(RegisteredUser,Dashboard)
