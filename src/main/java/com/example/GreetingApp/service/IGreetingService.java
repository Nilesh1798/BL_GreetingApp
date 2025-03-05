package com.example.GreetingApp.service;



import com.example.GreetingApp.model.AuthUser;
import com.example.GreetingApp.model.Greeting;

//



public interface IGreetingService {



    Greeting addGreeting(AuthUser user);

    Greeting getGreetingById(long id);

}