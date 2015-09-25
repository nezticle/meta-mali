LICENSE = "Proprietary"
SECTION = "devel"
LIC_FILES_CHKSUM = "file://${WORKDIR}/END_USER_LICENSE_AGREEMENT.txt;md5=4b460f1c8e359a0586d1e08187f96210"

FILESEXTRAPATHS_prepend:= "${THISDIR}/${PN}_${PV}:"

SRC_URI = "\
	http://malideveloper.arm.com/downloads/SDK/LINUX/${PV}/Mali_OpenGL_ES_SDK_v${PV}.${PR}_Linux_x64.tar.gz;name=sdk \
	file://END_USER_LICENSE_AGREEMENT.txt \
	"

S = "${WORKDIR}/Mali_OpenGL_ES_SDK_v${PV}"

SRC_URI[sdk.md5sum] = "1fe58c50db597f03bcae6bb3438a9183"
SRC_URI[sdk.sha256sum] = "a36fdd1b8da84ac9f3164b392844183f5694c1399157c9cce39e3d3265a5a41b"

inherit mali_eula_unpack

do_install () {
	install -m 0755 -d ${D}${includedir}/EGL
    install -m 0755 ${S}/inc/EGL/* ${D}${includedir}/EGL
    install -m 0755 ${S}/simple_framework/inc/mali/EGL/* ${D}${includedir}/EGL

    install -m 0755 -d ${D}${includedir}/GLES2
    install -m 0755 ${S}/inc/GLES2/* ${D}${includedir}/GLES2

    install -m 0755 -d ${D}${includedir}/GLES3
    install -m 0755 ${S}/inc/GLES3/* ${D}${includedir}/GLES3

    install -m 0755 -d ${D}${includedir}/KHR
    install -m 0755 ${S}/inc/KHR/* ${D}${includedir}/KHR
}

ALLOW_EMPTY_${PN} = "1"