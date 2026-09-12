package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.DeleteObjectsResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class MultiObjectDeleteException extends AmazonS3Exception {
    private static final long serialVersionUID = -2004213552302446866L;
    private final List<DeleteObjectsResult.DeletedObject> deletedObjects;
    private final List<DeleteError> errors;

    /* loaded from: classes2.dex */
    public static class DeleteError {

        /* renamed from: a, reason: collision with root package name */
        private String f18819a;

        /* renamed from: b, reason: collision with root package name */
        private String f18820b;

        /* renamed from: c, reason: collision with root package name */
        private String f18821c;

        /* renamed from: d, reason: collision with root package name */
        private String f18822d;

        public void a(String str) {
            this.f18821c = str;
        }

        public void b(String str) {
            this.f18819a = str;
        }

        public void c(String str) {
            this.f18822d = str;
        }

        public void d(String str) {
            this.f18820b = str;
        }
    }

    public MultiObjectDeleteException(Collection<DeleteError> collection, Collection<DeleteObjectsResult.DeletedObject> collection2) {
        super("One or more objects could not be deleted");
        ArrayList arrayList = new ArrayList();
        this.errors = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.deletedObjects = arrayList2;
        arrayList2.addAll(collection2);
        arrayList.addAll(collection);
    }

    public List<DeleteObjectsResult.DeletedObject> getDeletedObjects() {
        return this.deletedObjects;
    }

    @Override // com.amazonaws.AmazonServiceException
    public String getErrorCode() {
        return super.getErrorCode();
    }

    public List<DeleteError> getErrors() {
        return this.errors;
    }
}
