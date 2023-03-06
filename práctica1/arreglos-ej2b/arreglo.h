#ifndef ARR_H
#define ARR_H
#define Max 100
#include "arreglo.c"

int isEmpty (TData arr);
int length (TData arr);
int add ( TData* arr, int element ); 
int ins ( TData* arr, int element, int pos );
void end ( TData* arr );
int delhd ( TData* arr );
int at (TData arr, int pos );
int del (TData* arr, int pos);
void show ( TData arr );

#endif
