(-------------------------------------------------------------------------)
(Author:     Dave Mariano)
(Date:       March 2, 2015)
(Filename:   panG-code)
(--------------------------------------------------------------------------)

(---DeltaBot Units, Limits, Rates---)
(            Axis:          X       Y        Z                            ) 
(  Steps per Unit:     106.67  106.67   106.67                            )
(    Max Position:      115mm   115mm    130mm   *Z's min endstop is lower) 
(    Min Position:        0mm     0mm      0mm                         )    
(    Max Feedrate:        200     200      200                         )

(---Endstops---   )
(    X and Y endstops are on their own circuit boards. They have their     )
(    own pullup resistors, and so the pullup resistors on the board should )
(    be disabled.  The logic on these endstops also needs to be inverted.  )
    
(    UNCOMMENT UNDER #ifndef ENDSTOPPULLUPS:)
(        #define ENDSTOPPULLUP_XMIN)
(        #define ENDSTOPPULLUP_YMIN)

(    CHANGE VALUES:)
(        const bool X_MIN_ENDSTOP_INVERTING to true)
(        const bool y_MIN_ENDSTOP_INVERTING to true)

(-------------------------------------------------------------------------)

; GCode for panning 
G21                              ;metric is good!
G90                              ;absolute positioning
T0                                 ;select new extruder
G28                               ;go home
G92 E0                          ;set extruder home
M104 S230.0                   ;set temperature to 230.0
G1 X20 Y20 F500            ;Move away from 0.0, so we use the same reset (in the layer code) for each layer


G1 F70
;G1 Z0.2 E0 F70

G92 X75 Y75 Z75
G1 X100 Y100 Z50 E166 F2300 	;tilt down on Z 25mm
;G4 S2 				            
G1 X50 Y50 Z100 E167 F2300      ;Tilt down on XY 25mm
;G4 S2
G1 X75 Y75 Z75 E168 F2300       ;Level axis	




