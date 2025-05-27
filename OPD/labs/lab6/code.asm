ORG  0x4
V2:	WORD  $INT2, 0x180
   		ORG  0x6
V3:	WORD $INT3, 0x180
   		ORG  0x010
 X:		WORD 0x036
		ORG  0x040
		
STRAT:	DI
			LD   #0xA   
			OUT  5
			LD   #0xB   
			OUT  7
			
WHILE:	DI   
			LD   (X)
   			INC   
   			INC
   			CMP  #0xD6   
   			BMI  LOAD1
   			BR  SAVE1
   			
LOAD1:	NOP
   			LD   #0x0D6   
   			NOP
   			
SAVE1:	ST   (X)   
			EI
			BR  WHILE   
			ORG  0x060
			
INT3:		NOP   
			PUSH
			DI   
			LD   (X)
			ADD  (X)   
			ADD  (X)
   			ADD  #4   
   			OUT  6
			EI   
			POP
			NOP   
			IRET
			
INT2:		NOP   
			PUSH
			IN   4   
			SXTB
			CMP  #0x29   
			BPL  LOAD2
			CMP  #0x6D   
			BMI  LOAD2
			BR  SAVE2
			
LOAD2:	LD   #0x06D
SAVE2:	ADD  (X)   
			ST   (X)
			POP   
			NOP
			IRET
