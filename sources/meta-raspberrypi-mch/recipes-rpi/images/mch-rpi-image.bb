DESCRIPTION = "Image for rpi mch"
LICENSE = "MIT"

inherit core-image

## Select image features
IMAGE_FEATURES += "ssh-server-dropbear"

CORE_IMAGE_EXTRA_INSTALL = "\
    bc \
    banner \
"
