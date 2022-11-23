package com.Studio.PhotoStudio.controllers;

import com.Studio.PhotoStudio.models.Image;
import com.Studio.PhotoStudio.security.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/test/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Image> saveImage(@RequestBody Image image)
    {
        System.out.println(image);
        return new ResponseEntity<Image>(imageService.saveImage(image), HttpStatus.CREATED);
    }
    @GetMapping("/allimages")
    public List<Image> getAllImages()
    {
        return imageService.getAllImages();
    }
    @GetMapping("{id}")
    public ResponseEntity<Image> getImageById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Image>(imageService.getImageById(id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id")Long id)
    {
        imageService.deleteImage(id);
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
    }
}
//
//@Controller
//public class ImageController {
//    @Autowired
//    private ImageRepo repo;
//    @PostMapping("/admin/save")
//    public RedirectView saveUser(Image user,
//                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {
//
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        user.setPhotos(fileName);
//
//        Image savedUser = repo.save(user);
//
//        String uploadDir = "user-photos/" + savedUser.getId();
//
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//
//        return new RedirectView("/users", true);
//    }
//}

//@Controller
//public class ImageGalleryController {
//
//    @Value("${uploadDir}")
//    private String uploadFolder;
//
//    @Autowired
//    private ImageGalleryService imageGalleryService;
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @GetMapping(value = {"/admin"})
//    public String addProductPage() {
//        return "index";
//    }
//
//    @PostMapping("/admin/saveImageDetails")
//    public @ResponseBody ResponseEntity<?> createProduct(@RequestParam("name") String name,
//                                                          @RequestParam("description") String description, Model model, HttpServletRequest request
//            ,final @RequestParam("image") MultipartFile file) {
//        try {
//            //String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
//            String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
//            log.info("uploadDirectory:: " + uploadDirectory);
//            String fileName = file.getOriginalFilename();
//            String filePath = Paths.get(uploadDirectory, fileName).toString();
//            log.info("FileName: " + file.getOriginalFilename());
//            if (fileName == null || fileName.contains("..")) {
//                model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
//                return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
//            }
//            String[] names = name.split(",");
//            String[] descriptions = description.split(",");
//            log.info("Name: " + names[0]+" "+filePath);
//            log.info("description: " + descriptions[0]);
//
//            try {
//                File dir = new File(uploadDirectory);
//                if (!dir.exists()) {
//                    log.info("Folder Created");
//                    dir.mkdirs();
//                }
//                // Save the file locally
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//                stream.write(file.getBytes());
//                stream.close();
//            } catch (Exception e) {
//                log.info("in catch");
//                e.printStackTrace();
//            }
//            byte[] imageData = file.getBytes();
//            ImageGallery imageGallery = new ImageGallery();
//            imageGallery.setName(names[0]);
//            imageGallery.setImage(imageData);
//            imageGallery.setDescription(descriptions[0]);
//            imageGalleryService.saveImage(imageGallery);
//            log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
//            return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("Exception: " + e);
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/admin/display/{id}")
//    @ResponseBody
//    void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<ImageGallery> imageGallery)
//            throws ServletException, IOException {
//        log.info("Id :: " + id);
//        imageGallery = imageGalleryService.getImageById(id);
//        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//        response.getOutputStream().write(imageGallery.get().getImage());
//        response.getOutputStream().close();
//    }
//
//    @GetMapping("/admin/imageDetails")
//    String showProductDetails(@RequestParam("id") Long id, Optional<ImageGallery> imageGallery, Model model) {
//        try {
//            log.info("Id :: " + id);
//            if (id != 0) {
//                imageGallery = imageGalleryService.getImageById(id);
//
//                log.info("products :: " + imageGallery);
//                if (imageGallery.isPresent()) {
//                    model.addAttribute("id", imageGallery.get().getId());
//                    model.addAttribute("description", imageGallery.get().getDescription());
//                    model.addAttribute("name", imageGallery.get().getName());
//                    return "imagedetails";
//                }
//                return "redirect:/home";
//            }
//            return "redirect:/home";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "redirect:/home";
//        }
//    }
//
//    @GetMapping("/admin/show")
//    String show(Model map) {
//        List<ImageGallery> images = imageGalleryService.getAllActiveImages();
//        map.addAttribute("images", images);
//        return "images";
//    }
//}
