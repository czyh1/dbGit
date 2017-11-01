package job;

import play.jobs.Job;
import play.jobs.OnApplicationStart;

/**
 * Created by Administrator on 2017/10/31.
 * 加入OnApplicationStart注解 会在应用程序启动前执行
 *   OnApplicationStart(async =true) 会在应用程序启动时在后台执行。
 *
 *      如果dev模式。应用程序将在第一个请求到达时执行
 */
@OnApplicationStart()
public class MyJob extends Job {

    @Override
    public void doJob() throws Exception {
        System.out.println("doJob");
        super.doJob();
    }

    @Override
    public Object doJobWithResult() throws Exception {
        System.out.println("doJobWithResult");
        return super.doJobWithResult();
    }
}
