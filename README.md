Delta Laser - Dave Mariano & Jordan Humphries

<h1 align="center">Delta Laser</h1>
<h2 align="center">Application and Server Repository</h2>


<p align="center">
<a href="https://github.com/d-mariano/DeltaControl/zipball/master">Download as .zip</a>
<br />
<a href="https://github.com/d-mariano/DeltaControl/tarball/master">Download as .tar.gz</a>
</p>




###Welcome

---
The major goal for Delta Laser is to relay commands from a mobile device to a control system.  The control system will manipulate the motors and carriages of a delta robot via G-code. Generally, some sort of device that is capable of running Python and has a USB port is required to run the server; we use a Raspberry Pi B+. There are libraries needed from the <a href="https://github.com/kliment/Printrun">Printrun</a> open-source package for this server to run. A robot controlled with a RepRap (Marlin, Repetier, etc) firmware loaded board is required. In our case, we have an Arduino Mega with a RAMPS (Reprap Arduino Mega Pololu Shield) and Marlin firmware controlling the 3 stepper motors of a delta robot. The RAMPS supports an SD card-reader attachment, it is optional to use one of these for storing routines. Which routines will be executed depends on the commands received from the client communicating with the Python server, pyDeltaServer. The pyDeltaServer server recognizes certain phrases/commands the client sends and will execture the appropriate G-code.</p>
<br />


###Building a Delta
####By: Dave Mariano
---

Before building this delta robot, I built a delta 3D printer based off of the [Kossel](http://reprap.org/wiki/Kossel) design.  In fact, it was to be a miniature version of the Kossel, a Kossel Mini.  I ordered a kit from [Mixshop](http://mixshop.com/index.php?main_page=product_info&cPath=59&products_id=220) and assembled it.  They actually call it the [Kossel Mini X](https://www.mixshop.com/docs/product/kossel).  Based off this experience, I was able to create a similar delta robot, but even smaller and not a printer.  This eliminated several build steps.  I will provide a list of categories required to build the Delta Laser robot. These categoires are linked to Mixshop's updated build instructions, so you will need to click on them. These categories alone do not describe all steps to build a 3D printer. If you want to try and build an actual 3D printer, then you should do some reserach [here](http://reprap.org/wiki/RepRap_Options#Models), pick a model that best suits you, and then decide if you want to purchase a kit or purchase materials separately.  Some kits provide more work than others, in building and in calibrating; do your research. The one I assembled was quite challenging, I enjoyed the process.  You should also consider the licenses used, they are listed under each model on the page I linked.  The Kossel is protected under the [GPL](http://reprap.org/wiki/GPL).  
<br />

####Optional
   The aluminum extrusions for my delta robot are cut to fit two bottom frames.  The reason I have two bottom frames is because one is used to hold the motors, being the top one, and the other will act as a chassis extension to hold the RAMPS and Arduino within.  This is not entirely necessary, but recommended.  If you choose this route, continue normally to the Requirements section.  If you do not choose this route, consider the following:
   * The 3 long alluminum pieces described below will only have to be 9 and 7/16 inches, not 11 and 7/16 inches.  
   * The amount of T-nuts and M3/M5 12mm socketed cap screws can be reduced by 30, so now you only need 60.  
   * I advise to still stick with 90 T-Nuts and socketed cap screws; they are handy for future attachments.
   * You will only need one set of 3 bottom frame 3D printed pieces, not 6.
   * The laser cut baseplate described will not be needed to hold a board, but would still act as a nice base anyway.
<br />

####Requirements
* 3x Stepper Motors, Nema 17 1.8° 2A 
* 3x 20mm x 20mm x 11.4375(11 and 7/16)inch Aluminum Extrusions (Make sure you read the above section: Optional)
* 12x 20mm x 20mm x 5.25inch Aluminum Extrusions (5.5" length is probably what I should have cut, try that first)
* 90x M3 or M5 T-Nuts (You might have trouble finding same size T-nuts, they must at least be M3)
* 90x M3 or M5 12mm Socketed Cap Screws (Size here depends on the T-Nuts you found)
* 6x M3 16mm Phillips Head (Head of a cap screw won't fit, observe Top Frame instructions)
* 6x M3 12mm (Cap screws may interfere with these and the next two requiremetns, proceed with caution)
* 3x M3 15 or 16 mm (These must go through 12mm of material and then a hex nut)
* 6x M2 16mm (These must go through 12mm of material and then a hex nut)
* 9x M8 12mm Socketed Cap Screws (For the carriages)
* 27x M8 Hex Nuts (For the carriages)
* 9x 608Z Ball Bearings (For the carriages)
* 3x 623 Ball Bearings (For the pulley system see Top Frame instructions)
* T2.5 Timing Belt (Get 2 meters to be safe)
* 3x 2.6 Pulley (For the stepper motor shafts)
* 6 Mechanical End-stops (At least 3, 6 is for Min and Max on the top and bottom of all 3 pillars)
<br />

####3D Printed Parts
1. 3x Kossel Base
2. 3x Kossel Top
3. 3x Kossel Carriages

####Laser-Cut Parts
1. 6x Carriage Plate
2. 1x Laser Shield
3. 1x Motor Shield
4. 1x Baseplate

####Build Instructions 
1. [Lower Frame](https://www.mixshop.com/docs/manual/kossel/lower_frame) (You may have to do this twice if you are extending the chassis)
2. [Top Frame](https://www.mixshop.com/docs/manual/kossel/top_frame)
3. [Carriage](https://www.mixshop.com/docs/manual/kossel/carriage)
4. [Frame Structure](https://www.mixshop.com/docs/manual/kossel/frame_structure)
5. [RAMPS/Arduino & Wiring](https://www.mixshop.com/docs/manual/kossel/electronic) (Ignore anything that has to do with a hotend, thermistor or Z probe)

