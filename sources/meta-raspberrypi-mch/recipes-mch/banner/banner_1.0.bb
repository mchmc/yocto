SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "CLOSED"

S = "${WORKDIR}"

SRC_URI = "file://banner \
	       file://banner.service \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "banner.service"

FILES_${PN} += "\${systemd_unitdir}/system/banner.service"
FILES_${PN} += "\${sysconfdir}/banner"

inherit systemd

do_install_append() {
    install -d ${D}${sysconfdir}
    install -d ${D}/${systemd_unitdir}/system

    install -m 644 ${WORKDIR}/banner ${D}/${sysconfdir}/banner
    install -m 644 ${WORKDIR}/banner.service ${D}/${systemd_unitdir}/system
}
