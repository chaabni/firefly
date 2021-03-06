Firefly
=======

The goal of the Firefly project is to showcase tools and frameworks developed at iMinds IoT lab and Homelab: 

* [AIOLOS](http://aiolos.intec.ugent.be/): an OSGi-based distributed computing platform for connecting IoT gateways to the cloud and end-user devices. 

* [DYAMAND](http://dyamand.intec.ugent.be) (DYnamic, Adaptive MAnagement of Networks and Devices): an interopability framework allowing to integrate with different sensors of different manufacturers.

The Firefly project provides a collection of Thing abstractions, allowing to interface with physical things in the OSGi world through OSGi services, a web-based dashboard UI that visualizes all available things in the network, and a rule engine to connect sensors to actuators.

Firefly also builds upon [OSGi enRoute](http://enroute.osgi.org/), a toolchain developed by the OSGi Alliance to facilitate the development of OSGi applications.


## Building and running Firefly

Since Firefly uses enRoute, make sure you have the following [prerequisites](http://enroute.osgi.org/qs/100-prerequisites.html):

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Eclipse IDE](https://www.eclipse.org/downloads/)
* [Git](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [Bndtools 3](http://bndtools.org/installation.html)

To build and run Firefly, import the Firefly projects into your Eclipse workspace and open the `be.iminds.iot.firefly.dashboard.application` project, which is the main dashboard application project. In that project, you find a couple of .bndrun files that describe a launch configuration:

* `standalone.bndrun` : a standalone run configuration deploying all features on a single runtime
* `gw.bndrun` : a gateway run configuration to deploy on a headless gateway; can connect to a repository configuration using AIOLOS
* `server.bndrun` : a server run configuration that can connect to one or more gateways running the gateway configuration providing a thing repository, UI and rule engine
* `debug.bndrun` : an extension of the standalone configuration with extra bundles for debugging

Right-click on the `debug.bndrun` file, select `Run as > Bnd OSGi Run Launcher` and the project should launch. Point your browser to `http://localhost:8080/be.iminds.iot.firefly.dashboard` and the web UI should show up.

By default the Firefly workspace also provides a command line build system using [Gradle](https://gradle.org/).
 

## Firefly dashboard UI

The dashboard UI shows all things connected and discovered. Double-click on a thing to configure its name and location. Things can be filtered on location using the menu on the top right. A long click allows to interact with an actuation device, for example allows to set the level and color of a lamp, and see the frames captured by a camera device (this is not tested on all browsers though).

![Image of dashboard UI](be.iminds.iot.firefly.dashboard.application/resources/be.iminds.iot.firefly.dashboard/images/screenshot.png)

The menu icon at the left side of the top bar gives you access to the rules dialog, where simple if-this-than-that rules can be configured with our rule engine implementation.


