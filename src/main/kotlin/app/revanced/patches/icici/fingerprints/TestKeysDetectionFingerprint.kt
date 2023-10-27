package app.revanced.patches.icici.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
object TestKeysDetectionFingerprint: MethodFingerprint(
   "Z",
    strings = listOf("test-keys"),
   customFingerprint = { methodDef, _ ->
      methodDef.definingClass == "Lcom/csam/icici/bank/imobile/RootDetection;"
   },
   )