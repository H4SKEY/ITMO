ORG 0x500
RES_ADDRESS: WORD $RES
EOF: WORD 0x0d
TMP: WORD ?

ORG 0x5DA

START: CLA

FIRST_SYMBOL: IN 7 AND #0x040
              BEQ FIRST_SYMBOL
              IN 6 SWAB
              ST (RES_ADDRESS)
              SWAB CMP EOF BEQ STOP
              
SECOND_SYMBOL: IN 7 AND #0x40
                
                BEQ SECOND_SYMBOL
                IN 6
                ST TMP
                ADD (RES_ADDRESS) ST (RES_ADDRESS)+                
                LD TMP
                CMP EOF
                BEQ STOP
                JUMP FIRST_SYMBOL

STOP: HLT

ORG 0x587
RES: WORD ?
