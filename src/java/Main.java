public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute();
    }
}

interface ModelLayer {
    Student getStudent();
}

class Student {
    String name = "Max";
    int age = 25;
}

class DbLayer implements ModelLayer {

    @Override
    public Student getStudent() {
        return new Student();
    }
}

interface View {
    void showStudent(Student student);
}

class ConsoleView implements View {

    @Override
    public void showStudent(Student student) {
        System.out.println(student.name + "  " + student.age);

    }
}

class Controller {
    ModelLayer modelLayer = new DbLayer();
    View view = new ConsoleView();
    void execute() {
        Student student = modelLayer.getStudent();
        view.showStudent(student);
    }
}