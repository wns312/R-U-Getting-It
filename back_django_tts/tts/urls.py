from django.urls import path

from . import views

app_name='tts'
urlpatterns = [
    path('', views.tts, name='tts'),
]
