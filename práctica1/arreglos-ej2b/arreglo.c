#include <stdio.h>
#include <stdlib.h>
#include "arreglo.h"
#define Max 100

typedef struct{
    int a[Max];
    int cant;
}TData;

int isEmpty (TData arr){
    return (arr.cant == 0);
}

int length (TData arr){
    return (arr.cant);
}

int add ( TData* arr, int element ){
    if(arr->cant == Max){
		return -1;
	}
    int i;
    for( i=(arr->cant -1) ; i>=0 ; i--){
        arr->a[i+1] = arr->a[i];
    }

    arr->a[0] = element;
    arr->cant++;
    return 0;
} 

int ins ( TData* arr, int element, int pos ){
    if ( pos < 0 || pos > arr->cant || arr->cant == Max){
		return -1;
	}
    int i;
    for( i=(arr->cant-1); i>=pos ; i--){
        arr->a[i+1]=arr->a[i];
    }

    arr->a[pos] = element;
    arr->cant++;
    return 0;
}

void end ( TData* arr ){
    arr->cant --;
}

int delhd ( TData* arr ){
	if (arr->cant == 0){
		return -1;
	}
    int i;
    for(i=0; i<(arr->cant-1);i++){
        arr->a[i] = arr->a[i+1];
    }

    arr->cant --;
    return 0;
}

int at (TData arr, int pos ){
    return (arr.a[pos]);
}

int del (TData* arr, int pos){
    if ( pos < 0 || pos > arr->cant || arr->cant == 0){
		return -1;
	}

    int i;
    for( i=pos; i<(arr->cant-1);i++){
        arr->a[i] = arr->a[i+1];
    }

    arr->cant --;
}

void show ( TData arr ){
	printf("Arreglo: [");/
	for(int i=0; i < arr.cant ; i++ )
	{
		printf("%d, ", arr.a[i]);
	}
	printf("]");
}