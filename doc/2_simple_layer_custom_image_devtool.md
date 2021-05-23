# Layers

In yocto repository

```
bitbake-layers create-layer meta-live
```

Adding layer to build

```
vi build/conf/bblayers
```

And add new layer

```
BBLAYERS ?= " \
    ...
    /path/to/your/yocto/meta-live \
    "
```

Compile layer, where example is name of recipe in meta-live layer

```
bitbake example
```

# Image

```
mkdir yoto/meta-live/recipes-examples/images
cp ../../../poky/meta/recipes-core/images/core-image-minimal-dev.bb example-image.bb
```

Inside ```example-image.bb```

```
require full/path/to/your/core-image-minimal.bb

DESCRIPTION = "A small image just containing a calculator"

IMAGE_INSTALL += "bc"

or

IMAGE_INSTALL_append = " bc"

IMAGE_FEATURES += "ssh-server-dropbear"
```

To build

```
bitbake example-image
```

Example of run

```
runqemu qemuarm example-image nographic
```

# Devtool

```
TBD
```

## Adding new layer based on github repo

```
devtool add https://github.com/LetoThe2nd/this_is.git
or
devtool add https://your/github/project/that.git
```

## Revision of added recipe

```
devtool edit-recipe this-is
```

## Compile recipe based on adding by devtool

```
bitbake this-is
```

## Adding recipe to image

```
IMAGE_INSTALL += "bc this-is"
```

Require to rebuild image

```
bitbake example-image
```