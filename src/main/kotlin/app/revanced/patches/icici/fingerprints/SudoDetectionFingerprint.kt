package app.revanced.patches.icici.fingerprints


import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint


object SudoDetectionFingerprint: MethodFingerprint(
   "Z",
   strings = listOf("/sbin/su"),
   customFingerprint = { methodDef, _ ->
      methodDef.definingClass == "Lcom/csam/icici/bank/imobile/RootDetection;"
   },
)
