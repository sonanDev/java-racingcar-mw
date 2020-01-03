import com.sonan.mvc.Model;
import com.sonan.racing.controller.ContestController;
import com.sonan.racing.controller.ContestMakerController;
import com.sonan.racing.model.ContestModel;
import com.sonan.racing.view.ContestMakerView;
import com.sonan.racing.view.ContestView;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class Main {
  public static void main(String[] args) {
    // request mapping같은 건 없다고 생각하고 request라는 method를 수행한다.
    ContestModel model = makeContestRequest(null);
    startContestRequest(model);
  }

  private static ContestModel makeContestRequest(ContestModel model) {
    ContestModel currentModel = model;
    ContestMakerController controller = new ContestMakerController();
    ContestMakerView view = new ContestMakerView();

    view.print(model);
    currentModel = controller.activate(model);
    if (!controller.isReadyContest(currentModel)) {
      // 추가 입력을 받기 위해 재 request를 날린다.
      return makeContestRequest(currentModel);
    }
    return currentModel;
  }

  private static void startContestRequest(ContestModel model) {
    ContestController controller = new ContestController();
    ContestView view = new ContestView();

    while (!controller.isFinalStep(model)) {
      model = controller.activate(model);
      view.print(model);
    }
  }
}
