package com.cloud.tmc.kernel.api.bytedata;

/* loaded from: classes3.dex */
class ByteArrayPools {

    /* loaded from: classes3.dex */
    static class ByteArray127Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray127Pool() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.cloud.tmc.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[127];
        }
    }

    /* loaded from: classes3.dex */
    static class ByteArray2Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray2Pool() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.cloud.tmc.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[2];
        }
    }

    /* loaded from: classes3.dex */
    static class ByteArray4Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray4Pool() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.cloud.tmc.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[4];
        }
    }

    /* loaded from: classes3.dex */
    static class ByteArray8Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray8Pool() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.cloud.tmc.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[8];
        }
    }

    /* loaded from: classes3.dex */
    static abstract class ByteArrayPool extends Pool<byte[]> {
        private ByteArrayPool() {
            super(1, 8);
        }

        @Override // com.cloud.tmc.kernel.api.bytedata.Pool
        public synchronized void free(byte[] bArr) {
            super.free((ByteArrayPool) bArr);
        }

        @Override // com.cloud.tmc.kernel.api.bytedata.Pool
        public synchronized byte[] obtain() {
            return (byte[]) super.obtain();
        }
    }

    ByteArrayPools() {
    }
}
