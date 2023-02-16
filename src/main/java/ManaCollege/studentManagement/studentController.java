package ManaCollege.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
public class studentController {

// DataBase
     HashMap<Integer,Student> db=new HashMap<>();
     //Adding Student
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        if(!db.containsKey(student.getAdmNo())){
            db.put(student.getAdmNo(),student);
            return "Student Added Successfully";
        }
        return "Student Already present with admNo";
    }
    //Getting Student with admNo
    @GetMapping("/getStudent")
    public String getStudent(@RequestParam("no") int admNo){
        if(db.containsKey(admNo)){
            return db.get(admNo).getName()+" "+db.get(admNo).getBranch();
        }

        return "No student Found!";
    }
    //Get Student with name
    @GetMapping("/getAdmNo")
    public String getStudent(@RequestParam("name") String name){
        for(int no: db.keySet()){
            if(db.get(no).getName().equals(name)){
                return "AdmNo: "+db.get(no).getAdmNo()+" Branch: "+db.get(no).getBranch();
            }
        }
        return "No Student is Found";
    }
    //Update Student with admno and Name
    @PutMapping("/update/{admNo}/{name}")
    public String updateStudent( @PathVariable("admNo") int admNo, @PathVariable("name") String name){
        if(db.containsKey(admNo))
        {
            db.get(admNo).setName(name);
            return "Successfully Updated Name!";
        }

        return "No Student Found";
    }
    //Updating branch with name
    @PutMapping("/update/{name}/")
    public String updateStudent(@PathVariable("name") String name,@RequestParam("branch") String branch){
        for(int no: db.keySet())
        {
            if(db.get(no).getName().equals(name)){
                db.get(no).setBranch(branch);
                return "Successfully updated Branch";
            }

        }
        return "No Student Found!";
    }
    //Deleteing witha admNo
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody int admNo){
        if(db.containsKey(admNo))
        {
            System.out.println();
            db.remove(admNo);
            return "Successfully Deleted! "+admNo;
        }
        return "No Student Found";
    }

    //Deleteing with Name
    @DeleteMapping("/delete/{name}")
    public String deleteStudent(@PathVariable("name") String name){
        for(int no: db.keySet()){
            if(db.get(no).getName().equals(name)){
                db.remove(no);
                return "Successfully Deleted "+name;
            }
        }
        return "No Student Found";
    }
}
