# Add project specific ProGuard rules here.

# Commons Compress references optional zstd-jni classes, but KSUPatcher only
# uses the bzip2/xz payload operations.
-dontwarn com.github.luben.zstd.**
