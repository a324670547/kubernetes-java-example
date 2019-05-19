package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1ServiceAccount;
import io.kubernetes.client.models.V1ServiceAccountList;

/**
 * - 描述：获取 ServiceAccount
 * - API版本： v1
 */
public class GetServiceAccount {

    /**
     * 获取全部 Namespace 的 ServiceAccount 列表
     */
    public static void getAllServiceAccount() throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 的 ServiceAccount 列表
        V1ServiceAccountList serviceAccountList = api.listServiceAccountForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1ServiceAccount item : serviceAccountList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 ServiceAccount 列表
     */
    public static void getNamespaceServiceAccountList(String namespace) throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 ServiceAccount 列表
        V1ServiceAccountList serviceAccountList = api.listNamespacedServiceAccount(namespace, null, null, null, null, null, null, null, null, null);
        for (V1ServiceAccount item : serviceAccountList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 ServiceAccount
     */
    public static void getNamespaceServiceAccount(String namespace, String serviceAccountName) throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 ServiceAccount
        V1ServiceAccount serviceAccount = api.readNamespacedServiceAccount(serviceAccountName, namespace, null, null, null);
        System.out.println(serviceAccount);
    }

    /**
     * 获取 ServiceAccount
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取全部 Namespace 的 ServiceAccount 列表
        getAllServiceAccount();
        // 获取某个 Namespace 的 ServiceAccount 列表
        getNamespaceServiceAccountList("kube-system");
        // 获取某个 Namespace 的某个 ServiceAccount
        getNamespaceServiceAccount("kube-system", "admin");
    }

}
