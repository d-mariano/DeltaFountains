M107
M104 S200 ; set temperature
G28 ; home all axes
M109 S200 ; wait for temperature to be reached
G90 ; use absolute coordinates
G21 ; set units to millimeters
G92 E0
M82 ; use absolute distances for extrusion
G1 F1800.000 E-1.00000
G92 E0

G1 X75 Y75 Z75 F75  E 1.03
G1 X50 Y100 E1.05619
G1 X100 Y50 E1.1
G1 X75 X75 Z75 E20

