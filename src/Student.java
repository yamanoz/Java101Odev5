public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya ,int sozmat,int sofiz,int sokim) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
            if(sozmat>=0&&mat<=100){
                this.mat.snote=sozmat;
            }
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
            if(sofiz>=0&&sofiz<=100){
                this.fizik.snote=sofiz;
            }
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
            if(kimya>=0&&kimya<=100){
                this.kimya.snote=sokim;
            }
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0 ||this.mat.snote==0||this.fizik.snote==0||this.kimya.snote==0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((this.fizik.note*(0.8)+this.fizik.snote*(0.2)) + (this.kimya.note*(0.8)+this.kimya.snote*(0.2)) + (this.mat.note*(0.8)+this.mat.snote*(0.2))) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Matematik Sozel Notu :"+this.mat.snote);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Fizik Sozel Notu :"+this.fizik.snote);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Kimya Sozel Notu :"+this.kimya.snote);
    }

}