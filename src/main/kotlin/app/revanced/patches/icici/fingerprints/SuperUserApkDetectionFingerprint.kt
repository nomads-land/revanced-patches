package app.revanced.patches.icici.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object SuperUserDetectionFingerprint: MethodFingerprint(
  "Z",
   strings = listOf("/system/app/Superuser.apk"),
   customFingerprint = { methodDef, _ ->
      methodDef.definingClass == "Lcom/csam/icici/bank/imobile/RootDetection;"
   },
)
