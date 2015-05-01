KBRANCH ?= "standard/base"

require recipes-kernel/linux/linux-yocto.inc

# board specific branches
KBRANCH_qemuarm  ?= "standard/arm-versatile-926ejs"
KBRANCH_qemuarm64 ?= "standard/qemuarm64"
KBRANCH_qemumips ?= "standard/mti-malta32"
KBRANCH_qemuppc  ?= "standard/qemuppc"
KBRANCH_qemux86  ?= "standard/common-pc"
KBRANCH_qemux86-64 ?= "standard/common-pc-64/base"
KBRANCH_qemumips64 ?= "standard/mti-malta64"

SRCREV_machine_qemuarm ?= "84448662cec5620ea32b3c222dca69e7d3d7ba7c"
SRCREV_machine_qemuarm64 ?= "a4d0c407cced779d1d84ea6284e48ea7366e9544"
SRCREV_machine_qemumips ?= "14c37927fe0d6e0ecd7e8c57d7fbd0828361ef2e"
SRCREV_machine_qemuppc ?= "deaab2afa62b7e903dbcea7b6c5ab9a58c3cf4a3"
SRCREV_machine_qemux86 ?= "a4d0c407cced779d1d84ea6284e48ea7366e9544"
SRCREV_machine_qemux86-64 ?= "a4d0c407cced779d1d84ea6284e48ea7366e9544"
SRCREV_machine_qemumips64 ?= "6f8e66bf8d7a215f11f8fb168a59fa1ef1b0ff87"
SRCREV_machine ?= "a4d0c407cced779d1d84ea6284e48ea7366e9544"
SRCREV_meta ?= "7215fe431391a322c7e39f410e7b8f2a2b507892"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-3.19.git;bareclone=1;branch=${KBRANCH},${KMETA};name=machine,meta"

LINUX_VERSION ?= "3.19.5"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "meta"
KCONF_BSP_AUDIT_LEVEL = "2"

COMPATIBLE_MACHINE = "qemuarm|qemuarm64|qemux86|qemuppc|qemumips|qemumips64|qemux86-64"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"
KERNEL_FEATURES_append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES_append_qemux86=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES_append_qemux86-64=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES_append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "" ,d)}"
