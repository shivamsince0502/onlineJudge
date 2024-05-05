import { Inter } from "next/font/google";
import "./globals.css";
import Navbar from "@/components/Layout/navbar";
import Footer from "@/components/Layout/footer";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Online Judge",
  description: "Online judge is a platform for solving programming problems.",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <Navbar />
        {children}
        <Footer/>
        </body>
    </html>
  );
}
