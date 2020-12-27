DATA SEGMENT 
DATA ENDS 
CODE SEGMENT
		mov eax, 1
		push eax
		mov eax, 1
		push eax
		pop ebx
		pop eax
		sub eax, ebx
		push eax
		jl etiq_vrai_1
		mov temp,0
		jmp etiq_fin_1
	etiq_vrai_1:
		mov temp,1
	etiq_fin_1:
		jz etiq_fin_0
		mov eax, 1
		push eax
		mov eax, 1
		push eax
		pop ebx
		pop eax
		sub eax, ebx
		push eax
		jl etiq_vrai_2
		mov temp,0
		jmp etiq_fin_2
	etiq_vrai_2:
		mov temp,1
	etiq_fin_2:
	etiq_fin_0
CODE ENDS