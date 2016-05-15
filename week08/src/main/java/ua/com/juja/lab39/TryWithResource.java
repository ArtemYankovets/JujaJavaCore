package ua.com.juja.lab39;

public class TryWithResource {

    public static void twoResource(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {

        Throwable mainThrowable = null;
        AutoCloseable resourceA = null;
        AutoCloseable resourceB = null;

        try {
            resourceA = factoryA.create();

            try {
                resourceB = factoryB.create();
            } catch (Throwable throwable) {
                mainThrowable = throwable;
                try {
                    resourceA.close();
                } catch (Throwable e) {
                    mainThrowable.addSuppressed(e);
                }
                throw mainThrowable;
            }

            try {
                body.runBody();
            } catch (Throwable throwable) {
                mainThrowable = throwable;
                try {
                    resourceB.close();
                } catch (Throwable e) {
                    mainThrowable.addSuppressed(e);
                }

                try {
                    resourceA.close();
                } catch (Throwable e) {
                    mainThrowable.addSuppressed(e);
                }
                throw mainThrowable;
            }

            try {
                resourceB.close();
            } catch (Throwable e) {
                mainThrowable = e;
                try {
                    resourceA.close();
                } catch (Throwable e1) {
                    mainThrowable.addSuppressed(e1);
                }
                throw mainThrowable;
            }

            resourceA.close();

        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}

interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}

interface TryBody {
    public void runBody() throws Throwable;
}