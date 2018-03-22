broadlink-openhab-binding
=====

Introduction
------------
This is building on the work of Cato Sognen, who developed the original Broadlink OpenHAB binding, but 
never placed his source code into the public domain.

This is ALPHA-quality software at this stage and should not be used for ANY important purpose. Many files are literally the result of decompilation with no attempt to fix style or layout problems.


Known Issues
------------

The original binding worked extremely well but there were a couple of issues related to multiple-device support (especially after a restart) that need to be addressed before this can be considered a mature binding. Github's issue tracking will be used for the basic stuff (getting this library working at all) but the main aims of this library are:

- Make the source code of the binding publicly available for scrutiny and improvement
- Fix multiple-device support
- Remove reliance on IP addresses (the device MAC address is all that is really needed) 

These main aims are based on my own personal needs and from reading of the [relevant OpenHAB forum post](https://community.openhab.org/t/broadlink-binding-for-rmx-a1-spx-and-mp-any-interest/22768). As mentioned above, please use Github Issues to log additional bugs/feature requests.


Credits
---------

- [Cato Sognen](https://community.openhab.org/u/cato_sognen)
- [OpenHAB](https://www.openhab.org/)
- [JAD](http://www.javadecompilers.com/jad) (Java Decompiler)

