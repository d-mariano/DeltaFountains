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

(Motors must already be physically positioned in the middle of their axis)
G92 X75 Y75 Z75     (Set position to middle of 115mm, no actual movement)
G01 X125 Y125 Z50   (Tilt down on Z 25mm)
G04 S2              (Dwell of 2 seconds)
G01 X50 Y50 Z125    (Tilt down on Y 25mm)
G04 S2              (Dwell for 2 seconds)
G01 X75 Y75 Z75     (Level axis)

                            ( ----OR---- )

(Motors must already be physically positioned in the middle of their axis)
X-25 Y-25 Z25 (Tilt down on X 25mm)
G04 S2        (Dwell for 2 seconds)
X50 Y50 Z-50  (Tilt down on Y 25mm, plus travel compensation 
                for previous tilt)
G04 S2        (Wait 2 seconds)
X-25 Y-25 Z25 (Level axis)




