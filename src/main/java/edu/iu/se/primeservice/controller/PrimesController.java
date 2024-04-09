package edu.iu.se.primeservice.controller;

import edu.iu.se.primeservice.services.IPrimesService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.jwt.Jwt; // Added import statement

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    IPrimesService primesService;
    private final MQSender mqSender;

    public PrimesController(IPrimesService primesService, MQSender mqSender){
        this.primesService = primesService;
        this.mqSender = mqSender;
    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        boolean result = primesService.isPrime(n);
        Object principal = SecurityContextHolder
                                .getContext().getAuthentication().getPrincipal();
        String username = ((Jwt) principal).getSubject(); // Fixed typo in method call
        System.out.println(username);
        mqSender.sendMessage(username, n, result); // Fixed method call
        return result; // Returning the result obtained earlier
    }
}
