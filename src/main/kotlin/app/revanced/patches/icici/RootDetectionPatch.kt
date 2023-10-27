package app.revanced.patches.icici

import app.revanced.extensions.exception
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patches.icici.fingerprints.SudoDetectionFingerprint
import app.revanced.patches.icici.fingerprints.SuperUserDetectionFingerprint
import app.revanced.patches.icici.fingerprints.TestKeysDetectionFingerprint


@Patch(
    name = "ICICI Root Detection Removal",
    compatiblePackages = [CompatiblePackage("com.csam.icici.bank.imobile")]
)
object RootDetectionPatch  : BytecodePatch(
    setOf(TestKeysDetectionFingerprint, SudoDetectionFingerprint, SuperUserDetectionFingerprint)
){
    override fun execute(context: BytecodeContext) {

        arrayOf(TestKeysDetectionFingerprint, SudoDetectionFingerprint, SuperUserDetectionFingerprint).forEach { fingerprint ->
            fingerprint.result?.mutableMethod?.addInstructions(
                0,
                """
                        const/4 v0, 0x0
                        return v0
                """
            ) ?: throw fingerprint.exception
        }
    }

}
