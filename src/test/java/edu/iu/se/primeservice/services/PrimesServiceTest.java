package edu.iu.se.primeservice.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {
    PrimesService primesService=new PrimesService();

    @Test
    void _45IsNotPrime() {
        int n=45;
        boolean expected=false;
        boolean actual=primesService.isPrime(n);
        assertEquals(expected,actual);
    }
    @Test
    void _5367890353678989IsNotPrime() {
        long n=5367890353678989L;
        boolean expected=false;
        boolean actual=primesService.isPrime(n);
        assertEquals(expected,actual);
    }
    @Test
    void _246357638IsNotPrime() {
        int n=246357638;
        boolean expected=false;
        boolean actual=primesService.isPrime(n);
        assertEquals(expected,actual);
    }
}