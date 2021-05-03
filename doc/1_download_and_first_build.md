# Download poky project

## Yocto repository

```
git clone git://git.yoctoproject.org/poky.git
```

## Yocto release tags

```
git tag
```

## Go to upper lever then yocto repository

```
cd ...
source poky/oe-init-build-env
```

## Shell environment set up for builds. Able to run bitbake

```
### Shell environment set up for builds. ###

You can now run 'bitbake <target>'

Common targets are:
    core-image-minimal
    core-image-full-cmdline
    core-image-sato
    core-image-weston
    meta-toolchain
    meta-ide-support
```

## Build core-image-minimal

```
time bitbake core-image-minimal
```

## After build core-image-minimal - results files

```
cd build/tmp/deploy/images/qemux86
```

## Run qemu

```
cd build
runqemu quemux86-64 nographic
```

# Add applications to yocto image

Add to ```conf/local.conf```

```
CORE_IMAGE_EXTRA_INSTALL = "bc"
```

Rebuild

```
time bitbake core-image-minimal
```

## Manifest - list of all image packages

```
build/tmp/deploy/images/qemux86/core-image-minimal-quemux*.rootfs.manifest
```

Or complete list of licenses

```
build/tmp/deploy/licenses/core-image-minimal-qemux86-*/license.manifest
```