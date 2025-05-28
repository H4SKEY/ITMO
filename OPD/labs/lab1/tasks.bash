-----------------------------------------------------
Задание 1
-----------------------------------------------------
mkdir lab0
touch lab0/kricketune4
touch lab0/mamoswine7
mkdir lab0/pidgey0
mkdir lab0/pidgey0/smoochum
touch lab0/pidgey0/drifloon
mkdir lab0/pidgey0/lillipup
mkdir lab0/rhyhorn1
touch lab0/rhyhorn1/feebas
touch lab0/rhyhorn1/goldeen
touch lab0/rhyhorn1/nidoranM
touch lab0/rhyhorn1/vullaby
mkdir lab0/rhyhorn1/growlithe
touch lab0/rhyhorn1/linoone
touch lab0/silcoon6
mkdir lab0/snorunt2
mkdir lab0/snorunt2/riolu
mkdir lab0/snorunt2/shiftry
mkdir lab0/snorunt2/combusken
touch lab0/snorunt2/hypno
echo "satk=6 sdef=5 spd=7" >lab0/kricketune4
echo -e "Тип диеты\nHerbivore" >lab0/mamoswine7
echo -e "Тип диеты Nullivore" >lab0/pidgey0/drifloon
echo -e "Тип покемона WATER\nNONE" >lab0/rhyhorn1/feebas
echo -e "Способоности Torrent Swift Swim Water\nVeil" >lab0/rhyhorn1/goldeen
echo -e "Ходы Body Slam Defence Curl Double-Edge Drill Run\nHelping Hand Tron Tail Mud-Slap Snock Wave Sleep Talk Snore Sucker\nPunch Super Fang Water Pulse" >lab0/rhyhorn1/nidoranM
echo -e "Способности Dark Art Mach Speed\nBig Pecks Overcoat" >lab0/rhyhorn1/vullaby
echo -e "Развитые способности Quick\nFeet" >lab0/rhyhorn1/linoone
echo -e "Тип покемона BUG NONE" >lab0/silcoon6
echo -e "Тип диеты Herbivore" >lab0/snorunt2/hypno

-----------------------------------------------------
Задание 2
-----------------------------------------------------
chmod 444 lab0/kricketune4
chmod 666 lab0/mamoswine7
chmod 512 lab0/pidgey0
chmod 550 lab0/pidgey0/smoochum
chmod 060 lab0/pidgey0/drifloon
chmod 733 lab0/pidgey0/lillipup
chmod 305 lab0/rhyhorn1
chmod 046 lab0/rhyhorn1/feebas
chmod 664 lab0/rhyhorn1/goldeen
chmod 624 lab0/rhyhorn1/nidoranM
chmod 644 lab0/rhyhorn1/vullaby
chmod 764 lab0/rhyhorn1/growlithe
chmod 620 lab0/rhyhorn1/linoone
chmod 044 lab0/silcoon6
chmod 733 lab0/snorunt2
chmod 550 lab0/snorunt2/riolu
chmod 511 lab0/snorunt2/shiftry
chmod 512 lab0/snorunt2/combusken
chmod 400 lab0/snorunt2/hypno

-----------------------------------------------------
Задание 3
-----------------------------------------------------
ln -P lab0/kricketune4 lab0/snorunt2/hypnokricketune
ln -s lab0/pidgey0 lab0/Copy_73
cat lab0/rhyhorn1/goldeen >lab0/silcoon6_15
cat lab0/rhyhorn1/feebas >>lab0/silcoon6_15
cp lab0/silcoon6 lab0/snorunt2/riolu
cp -r lab0/snorunt2 lab0/snorunt2/riolu
ln -s lab0/mamoswine7 lab0/rhyhorn1/vullabymamoswine
cp lab0/kricketune4 lab0/rhyhorn1/linoonekricketune


-----------------------------------------------------
Задание 4
-----------------------------------------------------
mkdir tmp
echo -e "1\n--- --- --- --- --- --- --- --- --- ---"
touch tmp/error1
cd lab0/rhyhorn1
wc -m $(ls -p | grep -v /) 2> ~/tmp/error1 | sort -n
cd ~
echo -e "--- --- --- --- --- --- --- --- --- ---"

echo -e "2\n--- --- --- --- --- --- --- --- --- ---"
cd lab0
ls -ltR | grep "^-" | grep "e$" | tail -n 2
cd ~
echo -e "--- --- --- --- --- --- --- --- --- ---"


echo -e "3\n--- --- --- --- --- --- --- --- --- ---"
cd lab0/rhyhorn1
cat $(ls -p | grep -v /) 2> /dev/null | grep -iv "r$"
cd ~
echo -e "--- --- --- --- --- --- --- --- --- ---"

echo -e "4\n--- --- --- --- --- --- --- --- --- ---"
cd lab0
cat kricketune4 2>&1 | grep -iv "e$"
cd ~
echo -e "--- --- --- --- --- --- --- --- --- ---"

echo -e "5\n--- --- --- --- --- --- --- --- --- ---"
touch tmp/task5
cd lab0/rhyhorn1
wc -l feebas goldeen nidoranM vullaby > ~/tmp/task5 2> /dev/null
cat ~/tmp/task5
cd ~
echo -e "--- --- --- --- --- --- --- --- --- ---"

echo -e "6\n--- --- --- --- --- --- --- --- --- ---"
cd lab0
ls -lR 2>/dev/null | grep "^-" | sort -r | head -n 2
cd ~
echo -e "--- --- --- --- --- --- --- --- --- ---"

-----------------------------------------------------
Задание 5
-----------------------------------------------------
rm lab0/silcoon6
rm lab0/rhyhorn1/goldeen
rm lab0/rhyhorn1/vullabymamoswi*
rm lab0/snorunt2/hypnokricketu*
rm -r lab0/pidgey0
rmdir lab0/pidgey0/smoochum



