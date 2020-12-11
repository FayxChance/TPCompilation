DATA SEGMENT 
	abc DD
DATA ENDS 
CODE SEGMENT
		mov eax, 5
		push eax
		mov eax, 6
		push eax
		mov eax, 7
		push eax
		pop ebx
		pop eax
		mul eax, ebx
		push eax
		pop ebx
		pop eax
		add eax, ebx
		push eax
		mov abc, eax
CODE ENDS