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

###Building a Delta
####By: Dave Mariano
---

Before building this delta robot, I built a delta 3D printer based off of the [Kossel](http://reprap.org/wiki/Kossel) design.  In fact, it was to be a miniature version of the Kossel, a Kossel Mini.  I ordered a kit from [Mixshop](http://mixshop.com/index.php?main_page=product_info&cPath=59&products_id=220) and assembled it.  They actually call it the [Kossel Mini X](https://www.mixshop.com/docs/product/kossel).  Based off this experience, I was able to create a similar delta robot, but even smaller and not a printer.  This eliminated several build steps.  I will provide a list of categories required to build the Delta Laser robot, they will be linked to Mixshop's updated build instructions.  These categories do not describe all steps to build a 3D printer.  If you want to try and build an actual 3D printer, then you should do some reserach [here](http://reprap.org/wiki/RepRap_Options#Models), pick a model that best suits you, and then decide if you want to purchase a kit or purchase materials separately.  Some kits provide more work than others, in building and in calibrating; do your research. The one I assembled was quite challenging, I enjoyed the process.  You should also consider the licenses used, they are listed under each model on the page I linked.  The Kossel is protected under the [GPL](http://reprap.org/wiki/GPL).  

####Requirements
* 3x Stepper Motors, Nema 17 1.8° 2A
* 3x 20mm x 20mm x 11.4375(11 and 7/16)inch Aluminum Extrusions 
* 12x 20mm x 20mm x 5.25inch Aluminum Extrusions (5.5" length is probably what I should have cut, try that first)
* 90x M3 or M5 T-Nuts (You might have trouble finding same size T-nuts, they must at least be M3)
* 90x M3 or M5 12mm Socketed Cap Screws (Depending on the T-Nuts you found) 
* 9x M8 12mm Socketed Cap Screws
* 27x M8 Hex Nuts
* More stuff
* 9x 608Z Ball Bearings
* 3x 623 Ball Bearings
* T2.5 Timing Belt (Get 2 meters to be safe)
* 6 Mechanical End-stops (At least 3, 6 is for Min and Max on the top and bottom of all 3 pillars)
* Tegan <3

####Build Instructions
1. [Lower Frame](https://www.mixshop.com/docs/manual/kossel/lower_frame)
2. [Top Frame](https://www.mixshop.com/docs/manual/kossel/top_frame)
3. [Carriage](https://www.mixshop.com/docs/manual/kossel/carriage)
4. [Frame Structure](https://www.mixshop.com/docs/manual/kossel/frame_structure)
5. [RAMPS/Arduino & Wiring](https://www.mixshop.com/docs/manual/kossel/electronic) (Ignore anything that has to do with a hotend, thermistor or Z probe)

