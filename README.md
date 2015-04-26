Delta Laser - Dave Mariano & Jordan Humphries

Delta Laser
===========

* * *

Application and Server Repository
----------------------------------

- - - - - -

[Download as .zip](https://github.com/d-mariano/DeltaControl/zipball/master")

[Download as .tar.gz](https://github.com/d-mariano/DeltaControl/tarball/master)

<h2>
<a id="welcome" class="anchor" href="#welcome" aria-hidden="true"><span class="octicon octicon-link"></span></a>Welcome</h2>
<p>The major goal for Delta Laser is to relay commands from a mobile device to a control system.  The control system will manipulate the motors and carriages of a delta robot via G-code. Generally, some sort of device that is capable of running Python and has a USB port is required to run the server; we use a Raspberry Pi B+. There are libraries needed from the <a href="https://github.com/kliment/Printrun">Printrun</a> open-source package for this server to run. A robot controlled with a RepRap (Marlin, Repetier, etc) firmware loaded board is required. In our case, we have an Arduino Mega with a RAMPS (Reprap Arduino Mega Pololu Shield) and Marlin firmware controlling the 3 stepper motors of a delta robot. The RAMPS supports an SD card-reader attachment, it is optional to use one of these for storing routines. Which routines will be executed depends on the commands received from the client communicating with the Python server, pyDeltaServer. The pyDeltaServer server recognizes certain phrases/commands the client sends and will execture the appropriate G-code.</p>
</section>
<section id="build_content">
<h2>Building a Delta</h2>
<h3>By: Dave Mariano</h3>
<p>Before building this delta robot, I built a delta 3D printer based off of the <a href="http://reprap.org/wiki/Kossel">Kossel</a> design.  In fact, it was to be a miniature version of the Kossel, a Kossel Mini.  I ordered a kit from <a href="http://mixshop.com/index.php?main_page=product_info&cPath=59&products_id=220">Mixshop</a> and assembled it.  They actually call it the <a href="https://www.mixshop.com/docs/product/kossel">Mini Kossel X</a>.  Based off this experience, I was able to create a similar delta robot, but even smaller and not a printer.  This eliminated several build steps.  I will provide a list of categories required to build the Delta Laser robot, they will be linked to Mixshop's updated build instructions.  These categories do not describe all steps to build a 3D printer.  If you want to try and build an actual 3D printer, then you should do some reserach <a href="http://reprap.org/wiki/RepRap_Options#Models">here</a>, pick a model that best suits you, and then decide if you want to purchase a kit or purchase materials separately.  Some kits provide more work than others, in building and in calibrating; do your research. The one I assembled was quite challenging, I enjoyed the process.  You should also consider the licenses used, they are listed under each model on the page I linked.  The Kossel is protected under the <a href="http://reprap.org/wiki/GPL">GPL</a>.  
</p>
<h2>Requirements</h2>
<ul>
  <li>3x Stepper Motors, Nema 17 1.8° 2A</li>
  <li>3x 20mm x 20mm x 11 7/16</li>
  <li>Tegan</li>
</ul>

</section>
</div>
</body>
</html>
